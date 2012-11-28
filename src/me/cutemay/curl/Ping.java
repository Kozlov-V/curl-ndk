package cn.testin.curl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import android.util.Log;

public class Ping {
	public static int pingHost(String host)
	{
		int status=-1;
		try {
			Process p = Runtime.getRuntime().exec("ping -c 4 " + host);
		    status=p.waitFor();
			BufferedReader localBufferedReader = new BufferedReader(
					new InputStreamReader(p.getInputStream()), 8192);
			 String line = null;
			 StringBuilder sb = new StringBuilder();
	            while((line = localBufferedReader.readLine())!=null){
	            	sb.append(line+"\n");
	            }
	         Log.d("PING",sb.toString());
	         localBufferedReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return status;
	}
}
