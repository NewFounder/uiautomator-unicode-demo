package com.example;

import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

import com.android.uiautomator.core.UiObject;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Runner extends UiAutomatorTestCase {
//	public void testDemo() throws UiObjectNotFoundException {
//
//        // Press on the HOME button.
//        getUiDevice().pressHome();
//
//        // Launch the "Google" apps via the All Apps screen.
//        UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
//        allAppsButton.clickAndWaitForNewWindow();
//        UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
//        appsTab.click();
//        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
//        appViews.setAsHorizontalList();
//        UiObject testApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),
//                "Google");
//        testApp.clickAndWaitForNewWindow();
//
//        // Get the google search text box
//        UiObject searchBox = new UiObject(
//                new UiSelector().className("com.google.android.search.shared.ui.SimpleSearchText"));
//
//        // do Japanese Input!
//        searchBox.setText(Utf7ImeHelper.e("����ˤ��ϣ�UiAutomator���������Ƥ��ޤ���"));
//    }

    public void testDemo() throws UiObjectNotFoundException {
        getUiDevice().pressHome();
        
        // click All apps
        UiObject AllApps = new UiObject(new UiSelector().packageName("com.android.launcher").className("android.widget.TextView").index(1));
        AllApps.click();
        //sleep 3s
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        // look for tmall
        UiScrollable listScrollable = new UiScrollable( new UiSelector().scrollable(true));
        listScrollable.setAsHorizontalList();	//���ù�������Ϊ�������
        listScrollable.scrollForward();			//��ǰ����һ��
        listScrollable.scrollTextIntoView("TMall");			//��������Ҫ���ҵ�Ԫ��
        
        UiObject myTestApp = new UiObject(new UiSelector().text("TMall"));
        myTestApp.click();
        
        UiObject searchLabel = new UiObject(new UiSelector().resourceId("com.tmall.wireless:id/banner_search_frame"));
        searchLabel.click();

        UiObject backLabel = new UiObject(new UiSelector().resourceId("com.tmall.wireless:id/search_title_bar_back"));
        backLabel.click();   
        
        //click catrgary label
        UiObject classLabel = new UiObject(new UiSelector().resourceId("com.tmall.wireless:id/categary_container"));
        classLabel.click();
        getUiDevice().pressBack();
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //积分
//        UiObject jiFenLabel = new UiObject(new UiSelector().resourceId("com.tmall.wireless:id/title").text(Utf7ImeHelper.e("����")));
//        jiFenLabel.click(); 
        getUiDevice().click(100, 400);
        
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //登录
        UiObject pageTitle = new UiObject(new UiSelector().resourceId("com.tmall.wireless:id/actionbar_title"));
        assertTrue("True", pageTitle.getText().equals("登录"));
        
        UiObject accountInput = new UiObject(new UiSelector().resourceId("com.tmall.wireless:id/et_login_name"));
        UiObject pwdInput = new UiObject(new UiSelector().resourceId("com.tmall.wireless:id/et_login_passwd"));
        UiObject loginBtn = new UiObject(new UiSelector().resourceId("com.tmall.wireless:id/btn_login_login"));
        
        String ACCOUNT = "你好1314";
        String PWD = "lovelove000111@@";
        
        //clear
        accountInput.clearTextField();
        
        accountInput.setText(Utf7ImeHelper.e(ACCOUNT));
        pwdInput.setText(PWD);
        loginBtn.click();
        
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        assertTrue("account assert", accountInput.getText().equals(ACCOUNT));
        System.out.print(accountInput.getText()+'\n');
    }
}
