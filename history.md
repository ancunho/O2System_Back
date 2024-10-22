# 共同
共同返回格式，`data`里放数据。


# 2020-03-28
1. customerId,projectId -> id  ======  OK
2. mobile-> phone  =====OK
3. ROLE: ROLE_ADMIN, ROLE_USER, ROLE_EDITOR  =====OK
4. 성,시,상세주소 분리(3개필드로) =====OK
5. 고객정보 -> 사진필드  =====OK
6. wechat_id -> wechat  =====OK





@Mapper
@Component("projectTimelineMapper")
public interface ProjectTimelineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectTimeline record);

    int insertSelective(ProjectTimeline record);

    ProjectTimeline selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectTimeline record);

    int updateByPrimaryKey(ProjectTimeline record);

    List<ProjectTimeline> selectByProjectId(@RequestParam(value = "projectId") String projectId);
}






<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.business.management.dao.ProjectTimelineMapper">
	<resultMap id="BaseResultMap" type="com.business.management.pojo.ProjectTimeline">
		<id column="ID" jdbcType="INTEGER" property="id"/>
		<result column="PROJECT_ID" jdbcType="INTEGER" property="projectId"/>
		<result column="TIMELINE_ID" jdbcType="VARCHAR" property="timelineId"/>
		<result column="TIMELINE_CONTENT" jdbcType="VARCHAR" property="timelineContent"/>
		<result column="TIMELINE_AUTHOR" jdbcType="VARCHAR" property="timelineAuthor"/>
		<result column="PARAM1" jdbcType="VARCHAR" property="param1"/>
		<result column="PARAM2" jdbcType="VARCHAR" property="param2"/>
		<result column="PARAM3" jdbcType="VARCHAR" property="param3"/>
		<result column="PARAM4" jdbcType="VARCHAR" property="param4"/>
		<result column="PARAM5" jdbcType="VARCHAR" property="param5"/>
		<result column="CREATETIME" jdbcType="VARCHAR" property="createtime"/>
		<result column="UPDATETIME" jdbcType="VARCHAR" property="updatetime"/>
	</resultMap>
	<sql id="Base_Column_List">
    ID, PROJECT_ID, TIMELINE_ID, TIMELINE_CONTENT, TIMELINE_AUTHOR, PARAM1, PARAM2, PARAM3, 
    PARAM4, PARAM5, date_format(CREATETIME, '%Y-%m-%d') AS CREATETIME, date_format(UPDATETIME, '%Y-%m-%d') AS UPDATETIME
  </sql>
	<select id="selectByPrimaryKey" parameterType="java.lang.Integer" resultMap="BaseResultMap">
		select
		<include refid="Base_Column_List"/>
		from tb_project_timeline
		where ID = #{id,jdbcType=INTEGER}
	</select>
	<delete id="deleteByPrimaryKey" parameterType="java.lang.Integer">
    delete from tb_project_timeline
    where ID = #{id,jdbcType=INTEGER}
  </delete>
	<insert id="insert" parameterType="com.business.management.pojo.ProjectTimeline">
    insert into tb_project_timeline (ID, PROJECT_ID, TIMELINE_ID, 
      TIMELINE_CONTENT, TIMELINE_AUTHOR, PARAM1, 
      PARAM2, PARAM3, PARAM4, 
      PARAM5, CREATETIME, UPDATETIME
      )
    values (#{id,jdbcType=INTEGER}, #{projectId,jdbcType=INTEGER}, #{timelineId,jdbcType=VARCHAR}, 
      #{timelineContent,jdbcType=VARCHAR}, #{timelineAuthor,jdbcType=VARCHAR}, #{param1,jdbcType=VARCHAR}, 
      #{param2,jdbcType=VARCHAR}, #{param3,jdbcType=VARCHAR}, #{param4,jdbcType=VARCHAR}, 
      #{param5,jdbcType=VARCHAR}, now(), now()
      )
  </insert>
	<insert id="insertSelective" parameterType="com.business.management.pojo.ProjectTimeline">
		insert into tb_project_timeline
		<trim prefix="(" suffix=")" suffixOverrides=",">
			<if test="id != null">
				ID,
			</if>
			<if test="projectId != null">
				PROJECT_ID,
			</if>
			<if test="timelineId != null">
				TIMELINE_ID,
			</if>
			<if test="timelineContent != null">
				TIMELINE_CONTENT,
			</if>
			<if test="timelineAuthor != null">
				TIMELINE_AUTHOR,
			</if>
			<if test="param1 != null">
				PARAM1,
			</if>
			<if test="param2 != null">
				PARAM2,
			</if>
			<if test="param3 != null">
				PARAM3,
			</if>
			<if test="param4 != null">
				PARAM4,
			</if>
			<if test="param5 != null">
				PARAM5,
			</if>
			<if test="createtime != null">
				CREATETIME,
			</if>
			<if test="updatetime != null">
				UPDATETIME,
			</if>
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
			<if test="id != null">
				#{id,jdbcType=INTEGER},
			</if>
			<if test="projectId != null">
				#{projectId,jdbcType=INTEGER},
			</if>
			<if test="timelineId != null">
				#{timelineId,jdbcType=VARCHAR},
			</if>
			<if test="timelineContent != null">
				#{timelineContent,jdbcType=VARCHAR},
			</if>
			<if test="timelineAuthor != null">
				#{timelineAuthor,jdbcType=VARCHAR},
			</if>
			<if test="param1 != null">
				#{param1,jdbcType=VARCHAR},
			</if>
			<if test="param2 != null">
				#{param2,jdbcType=VARCHAR},
			</if>
			<if test="param3 != null">
				#{param3,jdbcType=VARCHAR},
			</if>
			<if test="param4 != null">
				#{param4,jdbcType=VARCHAR},
			</if>
			<if test="param5 != null">
				#{param5,jdbcType=VARCHAR},
			</if>
			<if test="createtime != null">
				#{createtime,jdbcType=VARCHAR},
			</if>
			<if test="updatetime != null">
				#{updatetime,jdbcType=VARCHAR},
			</if>
		</trim>
	</insert>
	<update id="updateByPrimaryKeySelective" parameterType="com.business.management.pojo.ProjectTimeline">
		update tb_project_timeline
		<set>
			<if test="projectId != null">
				PROJECT_ID = #{projectId,jdbcType=INTEGER},
			</if>
			<if test="timelineId != null">
				TIMELINE_ID = #{timelineId,jdbcType=VARCHAR},
			</if>
			<if test="timelineContent != null">
				TIMELINE_CONTENT = #{timelineContent,jdbcType=VARCHAR},
			</if>
			<if test="timelineAuthor != null">
				TIMELINE_AUTHOR = #{timelineAuthor,jdbcType=VARCHAR},
			</if>
			<if test="param1 != null">
				PARAM1 = #{param1,jdbcType=VARCHAR},
			</if>
			<if test="param2 != null">
				PARAM2 = #{param2,jdbcType=VARCHAR},
			</if>
			<if test="param3 != null">
				PARAM3 = #{param3,jdbcType=VARCHAR},
			</if>
			<if test="param4 != null">
				PARAM4 = #{param4,jdbcType=VARCHAR},
			</if>
			<if test="param5 != null">
				PARAM5 = #{param5,jdbcType=VARCHAR},
			</if>
			<if test="createtime != null">
				CREATETIME = #{createtime,jdbcType=VARCHAR},
			</if>
			<if test="updatetime != null">
				UPDATETIME = #{updatetime,jdbcType=VARCHAR},
			</if>
		</set>
		where ID = #{id,jdbcType=INTEGER}
	</update>
	<update id="updateByPrimaryKey" parameterType="com.business.management.pojo.ProjectTimeline">
    update tb_project_timeline
    set PROJECT_ID = #{projectId,jdbcType=INTEGER},
      TIMELINE_ID = #{timelineId,jdbcType=VARCHAR},
      TIMELINE_CONTENT = #{timelineContent,jdbcType=VARCHAR},
      TIMELINE_AUTHOR = #{timelineAuthor,jdbcType=VARCHAR},
      PARAM1 = #{param1,jdbcType=VARCHAR},
      PARAM2 = #{param2,jdbcType=VARCHAR},
      PARAM3 = #{param3,jdbcType=VARCHAR},
      PARAM4 = #{param4,jdbcType=VARCHAR},
      PARAM5 = #{param5,jdbcType=VARCHAR},
      CREATETIME = #{createtime,jdbcType=VARCHAR},
      UPDATETIME = now()
    where ID = #{id,jdbcType=INTEGER}
  </update>

	<select id="selectByProjectId" resultType="com.business.management.pojo.ProjectTimeline">
		SELECT <include refid="Base_Column_List" />
		FROM 	TB_PROJECT_TIMELINE
		WHERE PROJECT_ID = #{projectId}
	</select>
</mapper>