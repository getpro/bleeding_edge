/*
 * Copyright (c) 2014, the Dart project authors.
 *
 * Licensed under the Eclipse Public License v1.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * This file has been automatically generated.  Please do not edit it manually.
 * To regenerate the file, use the script "pkg/analysis_server/spec/generate_files".
 */
package com.google.dart.server.generated.types;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.google.common.collect.Lists;
import com.google.dart.server.utilities.general.JsonUtilities;
import com.google.dart.server.utilities.general.ObjectUtilities;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/**
 * A description of the references to a single element within a single file.
 *
 * @coverage dart.server.generated.types
 */
@SuppressWarnings("unused")
public class Occurrences {

  public static final Occurrences[] EMPTY_ARRAY = new Occurrences[0];

  public static final List<Occurrences> EMPTY_LIST = Lists.newArrayList();

  /**
   * The element that was referenced.
   */
  private final Element element;

  /**
   * The offsets of the name of the referenced element within the file.
   */
  private final Integer[] offsets;

  /**
   * The length of the name of the referenced element.
   */
  private final Integer length;

  /**
   * Constructor for {@link Occurrences}.
   */
  public Occurrences(Element element, Integer[] offsets, Integer length) {
    this.element = element;
    this.offsets = offsets;
    this.length = length;
  }

  public boolean contains(int x) {
    for (int offset : offsets) {
      if (offset <= x && x < offset + length) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Occurrences) {
      Occurrences other = (Occurrences) obj;
      return
        ObjectUtilities.equals(other.element, element) &&
        Arrays.equals(other.offsets, offsets) &&
        other.length == length;
    }
    return false;
  }

  public static Occurrences fromJson(JsonObject jsonObject) {
    Element element = Element.fromJson(jsonObject.get("element").getAsJsonObject());
    Integer[] offsets = JsonUtilities.decodeIntegerArray(jsonObject.get("offsets").getAsJsonArray());
    Integer length = jsonObject.get("length").getAsInt();
    return new Occurrences(element, offsets, length);
  }

  public static List<Occurrences> fromJsonArray(JsonArray jsonArray) {
    if (jsonArray == null) {
      return EMPTY_LIST;
    }
    ArrayList<Occurrences> list = new ArrayList<Occurrences>(jsonArray.size());
    Iterator<JsonElement> iterator = jsonArray.iterator();
    while (iterator.hasNext()) {
      list.add(fromJson(iterator.next().getAsJsonObject()));
    }
    return list;
  }

  /**
   * The element that was referenced.
   */
  public Element getElement() {
    return element;
  }

  /**
   * The length of the name of the referenced element.
   */
  public Integer getLength() {
    return length;
  }

  /**
   * The offsets of the name of the referenced element within the file.
   */
  public Integer[] getOffsets() {
    return offsets;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    builder.append(element);
    builder.append(offsets);
    builder.append(length);
    return builder.toHashCode();
  }

  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("element", element.toJson());
    JsonArray jsonArrayOffsets = new JsonArray();
    for(Integer elt : offsets) {
      jsonArrayOffsets.add(new JsonPrimitive(elt));
    }
    jsonObject.add("offsets", jsonArrayOffsets);
    jsonObject.addProperty("length", length);
    return jsonObject;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append("element=");
    builder.append(element + ", ");
    builder.append("offsets=");
    builder.append(StringUtils.join(offsets, ", ") + ", ");
    builder.append("length=");
    builder.append(length);
    builder.append("]");
    return builder.toString();
  }

}
