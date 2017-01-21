package com.ordinap.taglib;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PaginationTaglib extends SimpleTagSupport {
	 private String uri;
	 private long offset;
	 private long count;
	 private long pageSize = 10;
	 private String previous = "Previous";
	 private String next = "Next";
	 private int maxLinkSize;
	 private long start = 1;
 
	 private Writer getWriter() {
		 JspWriter out = getJspContext().getOut();
		 return out;
		 }
	 
	@Override
	public void doTag() throws JspException {
		Writer out = getWriter();
		maxLinkSize+=1;
		try {
			out.write("<nav>");
			out.write("<ul class=\"pagination\">");

			 if(offset > 1) {
				 out.write(constructLink(offset-1,previous,null,false));
				 }else{
				 out.write(constructLink(1,previous,"disabled", true));
				 }

				 for(long i = start; i < maxLinkSize; i++) {
				 if(offset == i){
				 out.write(constructLink((i), String.valueOf((i)), "active", true));
				 }else{
				 out.write(constructLink(i, String.valueOf((i)), null , false));
				 }
				 }

				 if((offset+1) < maxLinkSize){
				 out.write(constructLink((offset+1),next,null,false));
				 }else{
				 out.write(constructLink(offset,next,"disabled",true));
				 }
			out.write("</ul>");
			out.write("</nav>");
		} catch (java.io.IOException ex) {
			throw new JspException("Error in Paginator tag", ex);
		}
	}

	 private String constructLink(long page, String text, String className, boolean disabled) {
		 
		 StringBuilder link = new StringBuilder("<li");
		  if (className != null) {
		   link.append(" class=\"");
		   link.append(className);
		   link.append("\"");
		  }
		  if(disabled)
		   link.append(">").append("<a href=\"#\">"+text+"</a></li>");
		  else
		   link.append(">").append("<a href=\""+uri+"?page="+page + "\">"+text+"</a></li>");
		  return link.toString();
		 }
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public int getMaxLinkSize() {
		return maxLinkSize;
	}

	public void setMaxLinkSize(int maxLinkSize) {
		this.maxLinkSize = maxLinkSize;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}
 
	 

}