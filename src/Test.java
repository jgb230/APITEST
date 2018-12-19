

import java.io.IOException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import clientAPI.ClientAPi;
import clientAPI.Info;
import clientAPI.Mythread;

public class Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		myCallBack mycb = new myCallBack();

	    char version = 0x01;
	    Info info = new Info();
	    
	    info.setAppId("4.00002");
	    info.setAppKey("!4j7oTLOXIKOFW@P");
	    info.setType(1);
	    info.setIp("172.16.0.27");
	    info.setPort(2345);
	    info.setVersion(version);
	    info.setMagic('$');

	    int ret = 0;
	    ret = ClientAPi.getInstance().initClient(info);
	    if (ret != 0 ){
	        LOG("init faile");
	        return;
	    }
	    ClientAPi.getInstance().setRecvHandler(mycb);
	    LOG("set callbak！\n" ,ret);
/*
	    String proid = "jgbtest" ;
	    String msg = "清除肾炎标签1";
	    int [] aid = new int[1];
	    ret = ClientAPi.getInstance().login(proid, aid);
	    if (ret != 0){
	        LOG("login faile ret:%d", ret);
	    }
	    int uid = aid[0];
	    LOG("====udi : %d" ,uid );
	    
	    for (int i = 0; i < 15; i++){
	        ret = ClientAPi.getInstance().sendMsg(uid, msg);
	        if (0 != ret){
	            LOG("send mes error: %s errno : %d\n" ,ret);
	        }
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    ClientAPi.getInstance().logout(proid, uid);
	    */
	    
	    TestThrea [] mt = new TestThrea[5];
	    for (int i = 0; i < 5; i++) {
	    	mt[i] = new TestThrea(i);
	    }
	    for (int i = 0; i < 5; i++) {
	    	mt[i].start();
	    }
	    
	}
	public static void LOG(String format, Object... args) {
    	System.out.println(new Formatter().format(format, args).toString());
    }
}
