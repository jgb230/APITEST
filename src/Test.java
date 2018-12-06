

import java.io.IOException;
import java.util.Formatter;

import clientAPI.ClientAPi;

public class Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		myCallBack mycb = new myCallBack();
		String appId = "4.00002";
	    String appKey = "Appkey";
	    String proid = "jgbtest";
	    String msg = "清除肾炎标签1";
	    int ret = 0;
	    ret = ClientAPi.getInstance().initClient(appId, appKey);
	    if (ret != 0 ){
	        LOG("intit faile");
	    }
	    int [] aid = new int[1];
	    ret = ClientAPi.getInstance().login(proid, aid);
	    if (ret != 0){
	        LOG("login faile ret:%d", ret);
	    }
	    int uid = aid[0];
	    LOG("====udi : %d" ,uid );
	    ClientAPi.getInstance().setRecvHandler(mycb);
	    LOG("set callbak！\n" ,ret);
	    for (int i = 0; i < 15; i++){
	        ret = ClientAPi.getInstance().sendMsg(uid, msg);
	        if (0 != ret){
	            LOG("send mes error: %s errno : %d\n" ,ret);
	        }
	        Thread.sleep(1000);
	    }
	    ClientAPi.getInstance().logout(proid, uid);
	}
	public static void LOG(String format, Object... args) {
    	System.out.println(new Formatter().format(format, args).toString());
    }
}
