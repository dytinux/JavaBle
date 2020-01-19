import java.io.*;
import java.util.BitSet;
class test  
{
	public static final int powerStatus =15;
	public static final int powerStatus1 =17;
    static BitSet bS1 =new BitSet();
	static byte[] bSend = new byte[10];
       /**
     * 将BitSet对象转化为ByteArray
     * @param bitSet
     * @return
     */
    public static byte[] bitSet2ByteArray(BitSet bitSet) {
        byte[] bytes = new byte[10];
        for (int i = 0; i < bytes.length*8; i++) {
            int index = i / 8;
            int offset = i % 8;
            bytes[index] |= (bitSet.get(i) ? 1 : 0) << offset;
        }
        return bytes;
    }
 
    /**
     * 将ByteArray对象转化为BitSet
     * @param bytes
     * @return
     */
    public static BitSet byteArray2BitSet(byte[] bytes) {
        BitSet bitSet = new BitSet(bytes.length * 8);
        int index = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j <= 7; j++) {
                bitSet.set(index++, (bytes[i] & (1 << j)) >> j == 1 ? true
                        : false);
            }
        }
        return bitSet;
    } 
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println("hi");
		//bS1.clear();
		//bS1.set(4,true);
		//if(bS1.get(4)){
		//    System.out.printf("%s\n",bS1.toString());
		//}
		bSend[0] = 0x57;
		bSend[1] = 0x61;
		bS1.clear();
		bS1 = byteArray2BitSet(bSend);
		//bS1.set(1,98,true);
		for( int i=0;i <= bSend.length*8; i++ ) {
    		if( bS1.get(i) ){
    		    System.out.printf("%d\n",i);
    		}
		}
		bS1.set(14, false);
		bS1.set(15, true);
		bS1.set(55, true);
		bSend = bitSet2ByteArray(bS1);
		for( int i=0;i < bSend.length; i++ ) {
    		System.out.printf("0x%x\n",bSend[i]);
		}

		//System.out.printf("%d\n",bS1.cardinality());
		
	}
}