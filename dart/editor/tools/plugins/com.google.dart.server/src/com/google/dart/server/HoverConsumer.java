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
 */
package com.google.dart.server;

/**
 * The interface {@code HoverConsumer} defines the behavior of objects that consume hover text
 * responses.
 * 
 * @coverage dart.server
 */
public interface HoverConsumer extends Consumer {

  /**
   * A set of {@link HoverInformation}s that have been computed.
   * 
   * @param hovers an array of computed {@link HoverInformation}s
   */
  public void computedHovers(HoverInformation[] hovers);
}