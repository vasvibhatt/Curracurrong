/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.datatype;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author !satt6882
 */
public class DRecord extends Composite{

    private int size;
    private Data[] array;

    public DRecord(int length)
    {
        size = length;
        array = new Data[size];
    }

    // return the data type of that data object
    public String getType()
    {
        return "DRecord";
    }

    // indicate wether primitive or composite data type
    public boolean isPrimitive()
    {
        return false;
    }

    public String tostring()
    {
        String str;
        String stp = "";
        for (int i = 0; i < size; i++)
        {
            if (!stp.equals(""))
                stp = stp + ",";
            str = array[i].tostring();
            stp = stp + str;
        }
        stp = "R[" + stp + "]";
        return stp;
    }


    /**
     * get the element at index equal idx
     * @param idx index of object
     * @return Data object
     * @throws ParsingException if given index is out of band
     */
    public Data getElement(int idx) throws ParsingException
    {
         // idx is in range
        if (idx <= size)
            return array[idx];
        else
            throw new ParsingException("out of band index in getElement()");
    }

    /**
     * set the passes element in specific index
     * @param idx index
     * @param element Data Object
     * @throws ParsingException if given index is out of band
     */
    public void setElement(int idx, Data element) throws ParsingException
    {
        if (idx <= size)
            array[idx] = element;
        else
            throw new ParsingException("out of band index in setElement()");
    }

    public int getSize()
    {
        return size;
    }

    public void print()
    {
        System.out.println("CASCADE: " + this.tostring());
    }

    public void readObjectOnSensor(ObjectInputStream ois) throws IOException, ClassNotFoundException, IllegalAccessException,InstantiationException {
        this.size = ois.readInt();
        Object[] tmp = new Object[this.size];
        tmp = (Object[]) ois.readObject();
        for (int i = 0; i<this.size; i++) {           
            this.array[i] = (Data) tmp[i];
        }
    }

	/**
	 * @see nodes.spotSensor.java.io.KSNSerializableInterface#writeObjectOnSensor(ObjectOutputStream)
	 */
	public void writeObjectOnSensor(ObjectOutputStream oos) throws IOException {
        oos.writeInt(size);
        oos.writeObject(array);
    }
}
