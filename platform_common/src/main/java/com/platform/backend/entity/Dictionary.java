package com.platform.backend.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Dictionary {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_data_dictionary.id
     *
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_data_dictionary.type_code
     *
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    private String typeCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_data_dictionary.type_name
     *
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    private String typeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_data_dictionary.value_id
     *
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    private Long valueId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_data_dictionary.value_name
     *
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    private String valueName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_data_dictionary.created_by
     *
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    private Long createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_data_dictionary.creation_date
     *
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    private Date creationDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_data_dictionary.modify_by
     *
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    private Long modifyBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_data_dictionary.modify_date
     *
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    private Date modifyDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_data_dictionary.id
     *
     * @return the value of t_data_dictionary.id
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_data_dictionary.id
     *
     * @param id the value for t_data_dictionary.id
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_data_dictionary.type_code
     *
     * @return the value of t_data_dictionary.type_code
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_data_dictionary.type_code
     *
     * @param typeCode the value for t_data_dictionary.type_code
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_data_dictionary.type_name
     *
     * @return the value of t_data_dictionary.type_name
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_data_dictionary.type_name
     *
     * @param typeName the value for t_data_dictionary.type_name
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_data_dictionary.value_id
     *
     * @return the value of t_data_dictionary.value_id
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public Long getValueId() {
        return valueId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_data_dictionary.value_id
     *
     * @param valueId the value for t_data_dictionary.value_id
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_data_dictionary.value_name
     *
     * @return the value of t_data_dictionary.value_name
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_data_dictionary.value_name
     *
     * @param valueName the value for t_data_dictionary.value_name
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_data_dictionary.created_by
     *
     * @return the value of t_data_dictionary.created_by
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_data_dictionary.created_by
     *
     * @param createdBy the value for t_data_dictionary.created_by
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_data_dictionary.creation_date
     *
     * @return the value of t_data_dictionary.creation_date
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_data_dictionary.creation_date
     *
     * @param creationDate the value for t_data_dictionary.creation_date
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_data_dictionary.modify_by
     *
     * @return the value of t_data_dictionary.modify_by
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public Long getModifyBy() {
        return modifyBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_data_dictionary.modify_by
     *
     * @param modifyBy the value for t_data_dictionary.modify_by
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_data_dictionary.modify_date
     *
     * @return the value of t_data_dictionary.modify_date
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_data_dictionary.modify_date
     *
     * @param modifyDate the value for t_data_dictionary.modify_date
     * @mbggenerated Mon Oct 31 08:57:27 CST 2022
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}