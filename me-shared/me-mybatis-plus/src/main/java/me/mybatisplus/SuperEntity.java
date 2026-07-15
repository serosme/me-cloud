package me.mybatisplus;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SuperEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableLogic(value = "0", delval = "UNIX_TIMESTAMP()")
    private Long deletedAt;
}
