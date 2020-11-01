package wam;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


 
//@XmlRootElement(namespace="http://www.w3.org/2005/Atom")
@XmlRootElement(name="feed")

//On both the above @XmlRootElement we are able to parse the content 

@XmlAccessorType(XmlAccessType.FIELD)
public class Feed {
	
	@XmlElement(namespace="http://a9.com/-/spec/opensearch/1.1/")
	private Long totalResults;
	
	@XmlElement(namespace="http://a9.com/-/spec/opensearch/1.1/")
	private Long startIndex;
	
	@XmlElement(namespace="http://a9.com/-/spec/opensearch/1.1/")
	private Long itemsPerPage;
	
	@XmlElement(namespace="http://www.w3.org/2005/Atom")
	private ArrayList<Entry> entry = new ArrayList<Entry>();
	
	public Feed(){		
		super();
	}
	
	public Feed(Long totalResults, Long startIndex, Long itemsPerPage, ArrayList<Entry> entry ){
		this.totalResults = totalResults;
		this.startIndex = startIndex;
		this.itemsPerPage = itemsPerPage;
		this.entry = entry;		
	}
	
	public Long getTotalResults(){
		return this.totalResults;
	}
	public void setTotalResults(Long totalResults){
		this.totalResults = totalResults;
	}	
	
	public Long getStartIndex(){
		return this.startIndex;
	}
	public void setStartIndex(Long startIndex){
		this.startIndex = startIndex;
	}
	
	public Long getItemsPerPage(){
		return this.itemsPerPage;
	}
	public void setItemsPerPage(Long itemsPerPage){
		this.itemsPerPage = itemsPerPage;
	}
	
	public ArrayList<Entry> getEntry(){
		return this.entry;
	}
	public void setEntry(ArrayList<Entry> entry){
		this.entry = entry;
	}
}
