package com.sbnri.pawankumarsbnri.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
@Entity(tableName = "repos")
data class DataResponse(


    @field:SerializedName("language")
	var language: String? = null,
    @Ignore
    @field:SerializedName("branches_url")
	var branchesUrl: String? = null,
    @Ignore
    @field:SerializedName("issue_comment_url")
	var issueCommentUrl: String? = null,
    @Ignore
    @field:SerializedName("labels_url")
	var labelsUrl: String? = null,
    @Ignore
    @field:SerializedName("subscribers_url")
	var subscribersUrl: String? = null,

    /*TODO*/
    @field:SerializedName("permissions")
	var permissions: Permissions? = null,
    @Ignore
    @field:SerializedName("releases_url")
	var releasesUrl: String? = null,
    @Ignore
    @field:SerializedName("svn_url")
	var svnUrl: String? = null,

    @PrimaryKey
    @field:SerializedName("id")
	var id: Int? = null,

    @field:SerializedName("forks")
	var forks: Int? = null,
    @Ignore
    @field:SerializedName("archive_url")
	var archiveUrl: String? = null,
    @Ignore
    @field:SerializedName("git_refs_url")
	var gitRefsUrl: String? = null,

    @Ignore
    @field:SerializedName("forks_url")
	var forksUrl: String? = null,

    @Ignore
    @field:SerializedName("statuses_url")
	var statusesUrl: String? = null,

    @Ignore
    @field:SerializedName("ssh_url")
	var sshUrl: String? = null,

    /*TODO*/
    @field:SerializedName("license")
	var license: License? = null,

    @field:SerializedName("full_name")
	var fullName: String? = null,
    @Ignore
    @field:SerializedName("size")
	var size: Int? = null,

    @Ignore
    @field:SerializedName("languages_url")
	var languagesUrl: String? = null,

    @field:SerializedName("html_url")
	var htmlUrl: String? = null,

    @Ignore
    @field:SerializedName("collaborators_url")
	var collaboratorsUrl: String? = null,
    @Ignore
    @field:SerializedName("clone_url")
	var cloneUrl: String? = null,

    @field:SerializedName("name")
	var name: String? = null,
    @Ignore
    @field:SerializedName("pulls_url")
	var pullsUrl: String? = null,
    @Ignore
    @field:SerializedName("default_branch")
	var defaultBranch: String? = null,

    @Ignore
    @field:SerializedName("hooks_url")
	var hooksUrl: String? = null,

    @Ignore
    @field:SerializedName("trees_url")
	var treesUrl: String? = null,

    @Ignore
    @field:SerializedName("tags_url")
	var tagsUrl: String? = null,
    @Ignore
    @field:SerializedName("private")
	var jsonMemberPrivate: Boolean? = null,
    @Ignore
    @field:SerializedName("contributors_url")
	var contributorsUrl: String? = null,
    @Ignore
    @field:SerializedName("has_downloads")
	var hasDownloads: Boolean? = null,
    @Ignore
    @field:SerializedName("notifications_url")
	var notificationsUrl: String? = null,

    /*TODO*/
    @field:SerializedName("open_issues_count")
	var openIssuesCount: Int? = null,

    @field:SerializedName("description")
	var description: String? = null,
    @Ignore
    @field:SerializedName("created_at")
	var createdAt: String? = null,
    @Ignore
    @field:SerializedName("watchers")
	var watchers: Int? = null,
    @Ignore
    @field:SerializedName("keys_url")
	var keysUrl: String? = null,
    @Ignore
    @field:SerializedName("deployments_url")
	var deploymentsUrl: String? = null,
    @Ignore
    @field:SerializedName("has_projects")
	var hasProjects: Boolean? = null,
    @Ignore
    @field:SerializedName("archived")
	var archived: Boolean? = null,
    @Ignore
    @field:SerializedName("has_wiki")
	var hasWiki: Boolean? = null,
    @Ignore
    @field:SerializedName("updated_at")
	var updatedAt: String? = null,

    @Ignore
    @field:SerializedName("comments_url")
	var commentsUrl: String? = null,

    @Ignore
    @field:SerializedName("stargazers_url")
	var stargazersUrl: String? = null,
    @Ignore
    @field:SerializedName("disabled")
	var disabled: Boolean? = null,
    @Ignore
    @field:SerializedName("git_url")
	var gitUrl: String? = null,
    @Ignore
    @field:SerializedName("has_pages")
	var hasPages: Boolean? = null,

    @Ignore
    @field:SerializedName("commits_url")
	var commitsUrl: String? = null,

    @Ignore
    @field:SerializedName("compare_url")
	var compareUrl: String? = null,

    @Ignore
    @field:SerializedName("git_commits_url")
	var gitCommitsUrl: String? = null,

    @Ignore
    @field:SerializedName("blobs_url")
	var blobsUrl: String? = null,

    @Ignore
    @field:SerializedName("git_tags_url")
	var gitTagsUrl: String? = null,

    @Ignore
    @field:SerializedName("merges_url")
	var mergesUrl: String? = null,

    @Ignore
    @field:SerializedName("downloads_url")
	var downloadsUrl: String? = null,

    @field:SerializedName("has_issues")
	var hasIssues: Boolean? = null,

    @Ignore
    @field:SerializedName("url")
	var url: String? = null,

    @Ignore
    @field:SerializedName("contents_url")
	var contentsUrl: String? = null,

    @Ignore
    @field:SerializedName("mirror_url")
	var mirrorUrl: String? = null,

    @Ignore
    @field:SerializedName("milestones_url")
	var milestonesUrl: String? = null,

    @Ignore
    @field:SerializedName("teams_url")
	var teamsUrl: String? = null,

    @field:SerializedName("fork")
	var fork: Boolean? = null,

    @Ignore
    @field:SerializedName("issues_url")
	var issuesUrl: String? = null,

    @Ignore
    @field:SerializedName("events_url")
	var eventsUrl: String? = null,

    @Ignore
    @field:SerializedName("issue_events_url")
	var issueEventsUrl: String? = null,

    @Ignore
    @field:SerializedName("assignees_url")
	var assigneesUrl: String? = null,

    @field:SerializedName("open_issues")
	var openIssues: Int? = null,
    @Ignore
    @field:SerializedName("watchers_count")
	var watchersCount: Int? = null,
    @Ignore
    @field:SerializedName("node_id")
	var nodeId: String? = null,
    @Ignore
    @field:SerializedName("homepage")
	var homepage: String? = null,

    @field:SerializedName("forks_count")
	var forksCount: Int? = null
)