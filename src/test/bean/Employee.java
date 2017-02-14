package test.bean;
/**   
* @Title: Employee.java 
* @Package test 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhongqiang.qiu
* @Company www.viewhigh.com
* @date 2016年6月14日 下午2:34:26 
* @version V1.0   
*/
public class Employee {
    private Long id;
    private String name;
    private Integer sex;
    private String address;
    private String job;
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
    public String toString(){
        String str="name:"+this.name+"   sex:"+this.sex+"     address:"+this.address+"       job:"+this.job;
        return str;
        
    }
}

