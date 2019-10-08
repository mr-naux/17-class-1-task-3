package tm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Cal {
	
	private int num = 0;
	public Teacher [] teachers = new Teacher[200];
	private String filepath;
	private File file;
	public Cal(String FP) {
		// TODO �Զ����ɵĹ��캯�����
		filepath = FP;
		file = new File(filepath);
		//System.out.println(filepath);
	}
	
	private long getLineNumber(File file) {
		//��ȡ�ļ�����
	    if (file.exists()) {
	        try {
	            FileReader fileReader = new FileReader(file);
	            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
	            lineNumberReader.skip(Long.MAX_VALUE);
	            long lines = lineNumberReader.getLineNumber() + 1;
	            fileReader.close();
	            lineNumberReader.close();
	            return lines;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return 0;
	}
	
	public void calculate() throws IOException {
		//����
		InputStreamReader reader=new InputStreamReader(new FileInputStream(file),"GBK");
        BufferedReader bfreader=new BufferedReader(reader);
        String line;
        for(int i = -1; i < (this.getLineNumber(file) - 1); i++) {
        	line = bfreader.readLine();
//	        System.out.println(line);
	        if(i >= 0) {
	        	String [] arr = line.split("\\s+"); //�ָ��ַ���
//        		for(String ss : arr){
//        	    	System.out.println(ss);
//        		}
//	        	System.out.println(arr[0]+","+teachers[i].name);
	        		teachers[i] = new Teacher();
	        		num++;
	        		teachers[i].name = arr[0];
	        		teachers[i].salary = Integer.parseInt(arr[1]);
	        		teachers[i].people = Integer.parseInt(arr[2]);
	        		teachers[i].date = Integer.parseInt(arr[3]);
//	        		System.out.println(teachers[i].name);
//	        		System.out.println(teachers[i].salary);
//	        		System.out.println(teachers[i].people);
//	        		System.out.println(teachers[i].date);
        	}
        }
        for(int i = 0; i < num; i++) {
        	if(teachers[i].salary < 26000) {
        		
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String createdate = sdf.format(date);
                
        		int workyears = (Integer.parseInt(createdate) - teachers[i].date) / 10000; //����
        		System.out.println(workyears);
        		int people_real = teachers[i].people + 1; //��������
        		int new_salary = teachers[i].salary + people_real * 100 + workyears * 50;
        		if(new_salary > 26000) {
        			new_salary = 26000;
        		}
        		teachers[i].salary = new_salary;
        	}
        	//System.out.println(teachers[i].salary);
        }
        
        	File f1=new File(file.getParent());//�����ļ�/Ŀ¼��·��
            File f2=new File(f1,"test_new.txt");//��һ������Ϊһ��Ŀ¼�ļ����ڶ�������ΪҪ�ڵ�ǰf1Ŀ¼��Ҫ�������ļ�
            
            PrintWriter printWriter =new PrintWriter(new FileWriter(f2,true),true);//�ڶ�������Ϊtrue�����ļ�ĩβд�� Ϊfalse��ӿ�ͷд��
            for(int i = 0; i < num; i++) {
            	printWriter.println(teachers[i].name + " " + teachers[i].salary + " " + teachers[i].people + " " + teachers[i].date);
            }
            new demo().symbal = 1;
            printWriter.close();//�ǵùر�������
        
        reader.close();
        bfreader.close();
	}
	
	/*public void print() {
		System.out.println(file.getName());
	}*/
}
