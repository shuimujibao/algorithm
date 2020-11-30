package interview.aibaba.gongming;

import lombok.Builder;
import lombok.Data;

/**
 * @author sunxiaoyu3
 * @description 组员信息
 * @createTime 2020/11/30 10:24:00
 */
@Data
@Builder
class User {
    /**
     * id
     */
    int id;
    /**
     * 星座 1～12
     */
    int constellation;
    /**
     * 部门 1～100
     */
    int department;
}
