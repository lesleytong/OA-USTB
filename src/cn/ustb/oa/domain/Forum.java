package cn.ustb.oa.domain;

/**
 * 版块列表
 * @author Lenovo
 *
 */
public class Forum {
	private Long id;
	private String name;
	private String description;
	private int position;
	
	//别忘了写get/set方法
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
