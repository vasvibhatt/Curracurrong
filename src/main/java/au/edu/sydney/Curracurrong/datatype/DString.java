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

package au.edu.sydney.Curracurrong.datatype;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
/**
 * @author Akon Dey (akon.dey@sydney.edu.au), University of Sydney
 * @author Vasvi Kakkad (vasvi.kakkad@sydney.edu.au), University of Sydney
 * @author Bernhard Scholz (bernhard.scholz@sydney.edu.au), University of Sydney
 */
public class DString extends Data {

    private String value;

    public DString() {
        value = "";
    }

    public DString(String s) {
        value = s;
    }

    // return the data type of that data object
    public String getType() {
        return "";
    }

    /**
     *
     * @param s
     */
    public void setValue(String s) {
        value = s;
    }

    /**
     *
     * @return
     */
    public boolean isPrimitive() {
        return true;
    }

    /**
     * 
     * @return
     */
    public String tostring()
    {
        return value;
    }


    /**
     * 
     * @param ois
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void readObjectOnSensor(ObjectInputStream ois) throws IOException, ClassNotFoundException, IllegalAccessException,InstantiationException {
        this.value = ois.readUTF();
    }

    /**
     * @see nodes.spotSensor.java.io.KSNSerializableInterface#writeObjectOnSensor(ObjectOutputStream)
     */
    public void writeObjectOnSensor(ObjectOutputStream oos) throws IOException {
        oos.writeUTF(value);
    }

}
