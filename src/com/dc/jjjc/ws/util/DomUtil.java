/*
 * 文 件 名:  DomUtil.java
 * 版    权:  DigitalChina Co., Ltd. Copyright 2001-2011,  All rights reserved
 * 作    者:  shenglg
 * 时    间:  2012-9-1
 */
package com.dc.jjjc.ws.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class DomUtil {

	public static Document createOrgDocument(List orgList, String czrydm) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("ROOT");
		Element version = root.addElement("VERSION");
		version.setText(getCurrentDateString());
		Element creator = root.addElement("CREATOR");
		creator.setText(czrydm);
		if (orgList != null) {
			Iterator iterator = orgList.iterator();
			while (iterator.hasNext()) {
				Map map = (Map) iterator.next();
				Element swjg = root.addElement("SWJG");
				Element swjg_dm = swjg.addElement("SWJG_DM");
				swjg_dm.setText(StringEx.sNullForLogic(map.get("swjg_dm")));
				Element swjg_mc = swjg.addElement("SWJG_MC");
				swjg_mc.setText(StringEx.sNullForLogic(map.get("swjg_mc")));
				Element sj_swjg_dm = swjg.addElement("SJ_SWJG_DM");
				sj_swjg_dm.setText(StringEx
						.sNullForLogic(map.get("sj_swjg_dm")));
				Element jbdm = swjg.addElement("JBDM");
				jbdm.setText(StringEx.sNullForLogic(map.get("jbdm")));
				Element swjg_dz = swjg.addElement("SWJG_DZ");
				swjg_dz.setText(StringEx.sNullForLogic(map.get("swjg_dz")));
				Element swjg_yb = swjg.addElement("SWJG_YB");
				swjg_yb.setText(StringEx.sNullForLogic(map.get("swjg_yb")));
				Element czdh = swjg.addElement("CZDH");
				czdh.setText(StringEx.sNullForLogic(map.get("czdh")));
			}
		}
		return document;
	}

	public static boolean writeToFile(Document document, String filePath) {
		OutputStreamWriter out = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(filePath),
					"utf-8");
			document.write(out);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static String getCurrentDateString() {
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date(System.currentTimeMillis()));
	}

	private static class StringEx {
		static String sNullForLogic(Object o) {
			return o != null ? o.toString() : "";
		}
	}

	public static void main(String[] args) {
		List list = new ArrayList();
		Map map = new HashMap();
		map.put("swjg_dm", "swjg_dm123");
		map.put("swjg_mc", "swjg_mc123");
		map.put("sj_swjg_dm", "sj_swjg_dm123");
		map.put("jbdm", "jbdm123");
		map.put("swjg_dz", "swjg_dz123");
		map.put("swjg_yb", "swjg_yb123");
		map.put("czdh", "czdh123");
		list.add(map);
		System.out.println(createOrgDocument(list, "123").asXML());
	}
}
