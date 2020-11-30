package interview.aibaba.gongming;

import lombok.Data;

import java.util.List;

/**
 * @author sunxiaoyu3
 * @description 小组信息
 * @createTime 2020/11/30 10:46:00
 */
@Data
public class GroupInformation {

    /**
     * 小组成员信息
     */
    List<User> userList;
}
