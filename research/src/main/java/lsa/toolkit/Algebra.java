/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lsa.toolkit;


public final class Algebra {

  private Algebra() {
  }

  /** Returns sqrt(a^2 + b^2) without under/overflow. */
  public static double hypot(double a, double b) {
    double r;
    if (Math.abs(a) > Math.abs(b)) {
      r = b / a;
      r = Math.abs(a) * Math.sqrt(1 + r * r);
    } else if (b != 0) {
      r = a / b;
      r = Math.abs(b) * Math.sqrt(1 + r * r);
    } else {
      r = 0.0;
    }
    return r;
  }
  
  /**
   * Compute Maximum Absolute Row Sum Norm of input Matrix m
   * http://mathworld.wolfram.com/MaximumAbsoluteRowSumNorm.html 
   */
  public static double getNorm(Matrix m) {
    double max = 0.0;
    for (int i = 0; i < m.numRows(); i++) {
      int sum = 0;
      double[] cv = m.m[i];
      for (int j = 0; j < cv.length; j++) {
        sum += (int) Math.abs(cv[j]);
      }
      if (sum > max) {
        max = sum;
      }
    }
    return max;
  }

}
