// Copyright (c) 2012, the Dart project authors.  Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

main() {
  foo(true, [0]);
  // TODO(ngeoffray): Avoid bailout if argument isn't array.
  // foo(false, "bar");
}

foo(check, listOrString) {
  if (check) {
    Expect.equals(0, listOrString[0]);
    listOrString[0] = 1;
    Expect.equals(1, listOrString[0]);
  } else {
    Expect.equals("foobar", "foo" + listOrString);
  }
}
