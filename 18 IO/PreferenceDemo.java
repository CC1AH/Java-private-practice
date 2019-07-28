package f;
//preference APIÊ¹ÓÃÊ¾Àý
import java.util.prefs.*;
public class PreferenceDemo {
	public static void main(String args[]) throws BackingStoreException {
		Preferences preferences = Preferences.userNodeForPackage(PreferenceDemo.class);
		for(int i=0;i<5;++i) {
			preferences.put(i+"", "Content" + i);
		}
		for(int i=5;i<10;++i) {
			preferences.putInt(i+"",i);
		}
		for(String key:preferences.keys()) {
			System.out.println(key + ": " + preferences.get(key, null));
		}
	}
}
