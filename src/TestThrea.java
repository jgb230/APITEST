import java.util.Formatter;

import clientAPI.ClientAPi;

public class TestThrea extends Thread {
	int m_i;
	TestThrea(int i){
		m_i = i;
	}
	public void run() {
		String proid = "jgbtest" + String.valueOf(m_i);
	    String msg = "清除肾炎标签1";
	    int [] aid = new int[1];
	    int ret = ClientAPi.getInstance().login(proid, aid);
	    if (ret != 0){
	        LOG("login faile ret:%d", ret);
	    }
	    int uid = aid[0];
	    LOG("====udi : %d proid %s" ,uid , proid);
	    
	    for (int i = 0; i < 2; i++){
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
	}
	
	public static void LOG(String format, Object... args) {
    	System.out.println(new Formatter().format(format, args).toString());
    }
}
