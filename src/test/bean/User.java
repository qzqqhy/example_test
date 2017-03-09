package test.bean;

/**
 * @Title: User.java
 * @Package test
 * @Description: 用户bean
 * @author zhongqiang.qiu
 * @Company www.viewhigh.com
 * @date 2016年6月14日 上午11:00:26
 * @version V1.0
 */
public class User {
	private Long id;
	private String name;
	private Integer sex;
	private String address;
	private String job;

	public User() {

	}

	public User(String name, Integer sex) {
		this.name = name;
		this.sex = sex;
	}

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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String toString() {
		return this.getName() + "  " + this.sex;
	}
}
