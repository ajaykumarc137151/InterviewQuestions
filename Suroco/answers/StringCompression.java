import java.io.*;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringCompression {

    static String dedup(String inputStr,int chunkSize){

            byte[] byteArray = inputStr.getBytes();
            Integer chunkIndex = 0;
            int bytesIndex = 0;
            HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
            HashMap<String, Object> chunkbytesMap = new HashMap<>();
        HashMap<String, String> stringMap = new HashMap<>();
            StringBuilder stringBuilder = new StringBuilder();
            while (bytesIndex <= byteArray.length - 1) {
                byte[] chunkBytes = new byte[chunkSize];
                for (int i = 0; i < chunkSize; i++) {
                    if (bytesIndex < byteArray.length) {
                        chunkBytes[i] = byteArray[bytesIndex++];
                    }
                }
                Integer hashCode = new String(chunkBytes).hashCode();
                if (!hashMap.containsKey(hashCode.toString())) {
                    ArrayList<Integer> chunkOccurences = new ArrayList<>();
                    chunkOccurences.add(chunkIndex);
                    hashMap.put(hashCode.toString(), chunkOccurences);
                    chunkbytesMap.put(hashCode.toString(), chunkBytes);
                    stringMap.put(new String(chunkBytes),chunkIndex.toString());


                } else {

                      stringMap.put(new String(chunkBytes) ,   stringMap.get(new String(chunkBytes)+chunkIndex.toString()));
                }
                chunkIndex++;
            }
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            stringBuilder.append(entry.getKey()) ;
            stringBuilder.append(","+entry.getValue());
        }
            return stringBuilder.toString();

    }


    static String redup(String deduplicatedStr, int chunkSize) {

        return "abcdf";
    }

}
