package com.min.edu.main;

import com.min.edu.ctrl.InfoController;
import com.min.edu.vo.InfoVo;

public class InfoMain {

	public static void main(String[] args) {
        InfoController ctrl = new InfoController();
        InfoVo vo = new InfoVo("점심", "777");
        InfoVo result = ctrl.commandInsert(vo);
        System.out.println(result);
    }

}
