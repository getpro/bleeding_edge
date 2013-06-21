// Copyright (c) 2013, the Dart project authors.  Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

library barback.asset_id;

import 'dart:async';
import 'dart:io';

import 'package:pathos/path.dart' as pathos;

/// AssetIDs always use POSIX style paths regardless of the host platform.
final _posix = new pathos.Builder(style: pathos.Style.posix);

/// Identifies an asset within a package.
class AssetId {
  /// The name of the package containing this asset.
  final String package;

  /// The path to the asset relative to the root directory of [package].
  ///
  /// Source (i.e. read from disk) and generated (i.e. the output of a
  /// [Transformer]) assets all have paths. Even intermediate assets that are
  /// generated and then consumed by later transformations will still have
  /// a path used to identify it.
  ///
  /// Asset paths always use forward slashes as path separators, regardless of
  /// the host platform.
  final String path;

  /// Gets the file extension of the asset, if it has one, including the ".".
  String get extension => pathos.extension(path);

  /// Creates a new AssetId at [path] within [package].
  AssetId(this.package, String path)
      : path = _posix.normalize(path);

  /// Parses an [AssetId] string of the form "package|path/to/asset.txt".
  factory AssetId.parse(String description) {
    var parts = description.split("|");
    if (parts.length != 2) {
      throw new FormatException('Could not parse "$description".');
    }

    if (parts[0].isEmpty) {
      throw new FormatException(
          'Cannot have empty package name in "$description".');
    }

    if (parts[1].isEmpty) {
      throw new FormatException(
          'Cannot have empty path in "$description".');
    }

    return new AssetId(parts[0], parts[1]);
  }

  /// Deserializes an [AssetId] from [data], which must be the result of
  /// calling [serialize] on an existing [AssetId].
  ///
  /// Note that this is intended for communicating ids across isolates and not
  /// for persistent storage of asset identifiers. There is no guarantee of
  /// backwards compatibility in serialization form across versions.
  AssetId.deserialize(data)
      : package = data[0],
        path = data[1];

  /// Returns `true` of [other] is an [AssetId] with the same package and path.
  operator ==(other) =>
      other is AssetId &&
      package == other.package &&
      path == other.path;

  int get hashCode => package.hashCode ^ path.hashCode;

  /// Returns a new [AssetId] with the same [package] as this one and with the
  /// [path] extended to include [extension].
  AssetId addExtension(String extension) =>
      new AssetId(package, "$path$extension");

  /// Returns a new [AssetId] with the same [package] and [path] as this one
  /// but with file extension [newExtension].
  AssetId changeExtension(String newExtension) =>
      new AssetId(package, pathos.withoutExtension(path) + newExtension);

  String toString() => "$package|$path";

  /// Serializes this [AssetId] to an object that can be sent across isolates
  /// and passed to [deserialize].
  serialize() => [package, path];
}
