
package wam;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

public  class Entry {
	
	private String id;
	private Integer documentNumber;
	private String title;
	private String secondarySIC;
	private String companyName;
	
	public Entry(){
		super();
	}
	
	public Entry(String id,Integer documentNumber,String title,String secondarySIC,String companyName){
	
		this.id = id;
		this.documentNumber = documentNumber;
		this.title = title;
		this.secondarySIC = secondarySIC;
		this.companyName = companyName;
	}
	
	@XmlElement(namespace="http://www.w3.org/2005/Atom", name="id")
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
		
	@XmlElement(namespace="http://services.lexisnexis.com/shared/xmlschema/documentlist/1/", name="documentnumber")
	public Integer getDocumentNumber(){
		return this.documentNumber;
	}
	public void setDocumentNumber(Integer documentNumber){
		this.documentNumber = documentNumber;
	}
	 
	@XmlElement(namespace="http://www.w3.org/2005/Atom", name="title")
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
		
	@XmlElement(namespace="http://www.w3.org/2005/Atom", name="secondarySIC")
	public String getSecondarySIC(){
		return this.secondarySIC;
	}
	public void setSecondarySIC(String secondarySIC){
		this.secondarySIC = secondarySIC;
	}
	
	@XmlElement(namespace="http://www.w3.org/2005/Atom", name="companyName")
	public String getCompanyName(){
		return this.companyName;
	}
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	
	@Override
    public String toString() {
		   return "Company [id=" + id + ", documentNumber=" + documentNumber + ", title="
	                + title + ", secondarySIC=" + secondarySIC  + ",companyName=" + companyName+"]";
    }   
}
