import java.io.*;
import java.util.*;

public class DS01 {
    public static void main(String[] args) throws IOException {

        try {
            File file = new File("src/test01.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                if(line.isEmpty()){
                    break;
                }
                ArrList arrList = new ArrList();
                StringTokenizer st = new StringTokenizer(line, " ");

                while (st.hasMoreTokens()) {
                    int insert_num = Integer.parseInt(st.nextToken());
                    arrList.insert(insert_num);
                }
                arrList.print();
                String line2 = br.readLine();
                if (line2 != null ) {
                    int modify_num = Integer.parseInt(line2);
                    arrList.modify(modify_num);
                    arrList.print();
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("I/O exception");
        }
    }
}

class ArrList{
    private int a[];
    private int size;
    public ArrList(){
        a = new int[1];
        size = 0;
    }

    public void insert(int insert) {
        if (size == a.length) {
            resize(a.length*2);
        }
        a[size++] = insert;
    }

    private void resize(int newSize){
        if(size == a.length){
            int[] t = new int[newSize];
            for (int i=0; i<size; i++){
                t[i] = a[i];
            }
            a = t;
        }
    }

    public void print(){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+ " ");
        }
        System.out.println();
    }

    public void modify(int num) {
        int j = size-1;
        for (int i = 0; i < size; i++) {

            if (a[i]<num){
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                j--;
                i--;
            }
            if(i==j){
                break;
            }
        }
    }
}