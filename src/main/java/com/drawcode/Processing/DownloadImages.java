package com.drawcode.Processing;

import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.drawcode.Utils.url;

import java.io.IOException;

public class DownloadImages {

	private static final String folderPath = System.getenv("APPDATA") + "/DrawCode";

	public static void saveImages(int anzahlStart, int anzahlEnd, String keyword) {
		int count = 0;
		try {

			Document doc = Jsoup.connect(url.geturl(keyword.replaceAll(" ", "+"))).get();

			Elements img = doc.getElementsByTag("img");

			for (Element el : img) {
				count++;
				if (anzahlStart <= count && anzahlEnd >= count) {

					String src = el.absUrl("src");
					
					
					System.out.println("Image Found!");
					System.out.println("src attribute is : " + src);

					getImages(src);

				}
			}

		} catch (IOException ex) {
			System.err.println("There was an error");
			Logger.getLogger(DownloadImages.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private static void getImages(String src) throws IOException {


		int indexname = src.lastIndexOf("/");

		if (indexname == src.length()) {
			src = src.substring(1, indexname);
		}

		indexname = src.lastIndexOf("/");
		String name = src.substring(indexname, src.length());

		System.out.println(name);


		URL url = new URL(src);
		InputStream in = url.openStream();

		OutputStream out = new BufferedOutputStream(new FileOutputStream(folderPath + name));

		for (int b; (b = in.read()) != -1;) {
			out.write(b);
		}
		out.close();
		in.close();

	}
}