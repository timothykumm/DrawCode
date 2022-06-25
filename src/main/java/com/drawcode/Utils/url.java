package com.drawcode.Utils;

public class url {
	public static String geturl(String keyword) {
	return"https://stock.adobe.com/de/search/images?color=%23FFFFFF&filters%5Bcontent_type%3Aphoto%5D=1&filters%5Bcontent_type%3Aillustration%5D=1&filters%5Bcontent_type%3Azip_vector%5D=1&filters%5Bcontent_type%3Aimage%5D=1&filters%5Borientation%5D=square&k=" + keyword + "&order=relevance&price%5B%24%5D=1&safe_search=1&search_page=1&acp=&aco=" + keyword +"&limit=100&get_facets=1";
	}
}
