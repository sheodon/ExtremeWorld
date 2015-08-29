package com.jixianxueyuan.dto;


import java.io.Serializable;
import java.util.List;

public class TopicDTO implements Serializable
{
    private Long id;
    private String type;
    private String magicType;
    private String title;
    private String content;
    private int imageCount;
    private int replyCount;
    private int allReplyCount;
    private int viewCount;
    private int agreeCount;
    private String createTime;
    private int status;

    private UserMinDTO user;

    private VideoDetailDTO videoDetail;

    private MediaWrapDTO mediaWrap;

    private TaxonomyDTO taxonomy;

    private CourseMinDTO course;

    private List<HobbyDTO> hobbys;


    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMagicType() {
        return magicType;
    }

    public void setMagicType(String magicType) {
        this.magicType = magicType;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getContent()
    {
        return content;
    }
    public void setContent(String content)
    {
        this.content = content;
    }
    public int getImageCount()
    {
        return imageCount;
    }
    public void setImageCount(int imageCount)
    {
        this.imageCount = imageCount;
    }
    public int getReplyCount()
    {
        return replyCount;
    }
    public void setReplyCount(int replyCount)
    {
        this.replyCount = replyCount;
    }
    public int getAllReplyCount() {
        return allReplyCount;
    }

    public void setAllReplyCount(int allReplyCount) {
        this.allReplyCount = allReplyCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getAgreeCount() {
        return agreeCount;
    }

    public void setAgreeCount(int agreeCount) {
        this.agreeCount = agreeCount;
    }

    public String getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    public int getStatus()
    {
        return status;
    }
    public void setStatus(int status)
    {
        this.status = status;
    }
    public VideoDetailDTO getVideoDetail() {
        return videoDetail;
    }
    public void setVideoDetail(VideoDetailDTO videoDetail) {
        this.videoDetail = videoDetail;
    }
    public UserMinDTO getUser()
    {
        return user;
    }
    public void setUser(UserMinDTO user)
    {
        this.user = user;
    }
    public MediaWrapDTO getMediaWrap() {
        return mediaWrap;
    }
    public void setMediaWrap(MediaWrapDTO mediaWrap) {
        this.mediaWrap = mediaWrap;
    }
    public TaxonomyDTO getTaxonomy() {
        return taxonomy;
    }
    public void setTaxonomy(TaxonomyDTO taxonomy) {
        this.taxonomy = taxonomy;
    }

    public CourseMinDTO getCourse() {
        return course;
    }

    public void setCourse(CourseMinDTO course) {
        this.course = course;
    }

    public List<HobbyDTO> getHobbys() {
        return hobbys;
    }
    public void setHobbys(List<HobbyDTO> hobbys) {
        this.hobbys = hobbys;
    }

}
