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

import com.google.dart.engine.services.correction.CorrectionProposal;

/**
 * The interface {@code MinorRefactoringsConsumer} defines the behavior of objects that consume
 * minor refactorings {@link CorrectionProposal}s.
 * 
 * @coverage dart.server
 */
public interface MinorRefactoringsConsumer extends Consumer {
  /**
   * A set {@link CorrectionProposal}s has been computed.
   * 
   * @param proposals an array of computed {@link CorrectionProposal}s
   * @param isLastResult is {@code true} if this is the last set of results
   */
  public void computedProposals(CorrectionProposal[] proposals, boolean isLastResult);
}
