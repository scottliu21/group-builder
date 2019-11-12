//Updated 11/6/2019
package com.example.groupbuilder;

public class GroupClass {
    private String GroupName, GroupLeader;
    private Boolean GroupFree;
    private String[] GroupMem, resource;
    private int memCount;

    public GroupClass() {
        //Constructor
    }

    public GroupClass(String GroupName, String GroupLeader, int memCount, Boolean GroupFree,
                      String[] GroupMem, String[] resource) {
        this.GroupName = GroupName;
        this.GroupLeader = GroupLeader;
        this.memCount = memCount;
        this.GroupFree = GroupFree;
        this.GroupMem = GroupMem;
        this.resource = resource;
    }

    public void setGroupName(String groupName) { GroupName = groupName; }

    public void setGroupLeader(String groupLeader) { GroupLeader = groupLeader; }

    public void setGroupFree(Boolean groupFree) { GroupFree = groupFree; }

    public void setGroupMem(String[] groupMem) { GroupMem = groupMem; }

    public void setResource(String[] resource) { this.resource = resource; }

    public void setMemCount(int memCount) { this.memCount = memCount; }


    public String getGroupName() { return GroupName; }

    public String getGroupLeader() { return GroupLeader; }

    public Boolean getGroupFree() { return GroupFree; }

    public String[] getGroupMem() { return GroupMem; }

    public String[] getResource() { return resource; }

    public int getMemCount() { return memCount; }
}




