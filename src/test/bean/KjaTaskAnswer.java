package test.bean;

/**
 * Created by qiu_zhongqiang on 2017/6/30.
 */
public class KjaTaskAnswer {

    private Long   taskId;
    private double sortNum;
    private String itemId;
    private String titleId;
    private String subjectId;
    private Long targetId;
    public KjaTaskAnswer(){

    }

    /**
     * @param taskId
     * @param sortNum
     * @param itemId
     * @param titleId
     * @param subjectId
     */
    public KjaTaskAnswer(Long taskId, double sortNum, String itemId, String titleId, String subjectId) {
        this.taskId = taskId;
        this.sortNum = sortNum;
        this.itemId = itemId;
        this.titleId = titleId;
        this.subjectId = subjectId;
    }
    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public double getSortNum() {
        return sortNum;
    }

    public void setSortNum(double sortNum) {
        this.sortNum = sortNum;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
}
