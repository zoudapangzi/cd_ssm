package dao;

import domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    @Select("select * from member")
    public Member findById(String id);
}
