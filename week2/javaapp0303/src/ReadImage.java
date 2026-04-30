import java.io.*;
import java.net.*;
public class ReadImage {
  public static void main(String[] args) throws Exception{
	  String urlString="https://img.pchome.com.tw/cs/items/DYAQFNA900JREVC/000001_1771990525.jpg";
	  //URL url=new URL(urlString);
	  URL url= URI.create(urlString).toURL();
	  URLConnection cn=url.openConnection();
	  InputStream in=cn.getInputStream();
	  InputStream in2=new FileInputStream("c:/temp/img3.jpg");
	  //FileOutputStream file=new FileOutputStream("c:/temp/sony_earphone.jpg");
	  FileOutputStream file=new FileOutputStream("c:/temp/scene.jpg");
	  //byte[] bt=new byte[1024];
	  //int size=in.read(bt);
	  int value=0;
//	  while(size>0) {
//		  file.write(bt, 0, size);
//		  size=in.read(bt);
//	  }
	  int length=0;
	  long start=System.currentTimeMillis();
	  while((value=in2.read())!=-1){
		  file.write(value);
		  length++;
	  }
      file.close();
	  in2.close();
	  long end=System.currentTimeMillis();
	  
	  System.out.println("time:"+(end-start)/1000.0+" 秒");
	  System.out.println("size:"+length+" bytes");
  }
}
