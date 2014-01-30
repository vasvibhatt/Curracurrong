/**
 * Copyright 2014 University of Sydney, Australia.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package au.edu.sydney.Curracurrong.queryLanguage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saeed Attar, Vasvi Kakkad
 * University of Sydney
 */
public class StreamNodeSink extends StreamNode {
    @Override
    boolean isSenseOp() {
       return false;
    }

    @Override
    void setOutBandwidth(double inputBandwidth) {
        outBandwidth = 0; 
    }

    @Override
    void setOutType(String inputType){
        outType = "";
    }

    @Override
    void init() {
       super.init();
       if (!propertyList.containsKey("node")) {
          System.out.println("CASCADE: Sensor node is missing in sense operation " + getId());
       }
    }
}
