package com.example.demo.response.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about Users")
@SuppressWarnings("serial")
@Component
public class UserDto implements Serializable {
	
	@ApiModelProperty(notes="Name of user")
	private String name;
	
	@ApiModelProperty(notes="Mail of user")
	private String mail;
	
	@ApiModelProperty(notes="Designation of user")
	private String designation;
	
	@ApiModelProperty(notes="Allocated Project of user")
	private String project;
	
	@ApiModelProperty(notes="Oracle ID Assigned to user")
	private String oracleid;
	
	@ApiModelProperty(notes="Seat Location")
	private String seat;
	
	@ApiModelProperty(notes="Picture of User")
	private String img;
	
	@ApiModelProperty(notes="Img URL")
	private String imgurl;
	
	@ApiModelProperty(notes="Contact Extension")
	private String extension;
	
	@ApiModelProperty(notes="DU user belonngs to")
	private String du;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	//To String Method was already added
	public UserDto(String name, String mail, String designation, String project, String oracleid, String seat,
			String img, String imgurl, String extension, String du) {
		
		this.name = name;
		this.mail = mail;
		this.designation = designation;
		this.project = project;
		this.oracleid = oracleid;
		this.seat = seat;
		this.img = img;
		this.imgurl = imgurl;
		this.extension = extension;
		this.du = du;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getOracleid() {
		return oracleid;
	}
	public void setOracleid(String oracleid) {
		this.oracleid = oracleid;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getDu() {
		return du;
	}
	public void setDu(String du) {
		this.du = du;
	}

	//Added HashCode 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((du == null) ? 0 : du.hashCode());
		result = prime * result + ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((imgurl == null) ? 0 : imgurl.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((oracleid == null) ? 0 : oracleid.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		return result;
	}

	//Added equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (du == null) {
			if (other.du != null)
				return false;
		} else if (!du.equals(other.du))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (imgurl == null) {
			if (other.imgurl != null)
				return false;
		} else if (!imgurl.equals(other.imgurl))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (oracleid == null) {
			if (other.oracleid != null)
				return false;
		} else if (!oracleid.equals(other.oracleid))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		return true;
	}

	
	
	
	
}
