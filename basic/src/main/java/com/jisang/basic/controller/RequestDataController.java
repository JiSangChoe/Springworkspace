package com.jisang.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// HTTP * localhost:4000/request-data/** 
@RequestMapping("/request-data")
public class RequestDataController {
    
    // @RequestParam() : GET, DELETE 처럼 URL로 데이터를 전송하는 메서드에서 Query String으로 지정된 데이터를 가져오기 위해 사용

    // HTTP GET localhost:4000/request-data/request-param
    @GetMapping("/request-param")
    // http://localhost:4000/request-data/request-param?userId=qwer&userName=gildong
    public String getRequestParam(
        @RequestParam(name="userId") String userId,
        // @RequestParam(name="userName", required = false) String userName => userName은 필수가 아니라는 뜻
        @RequestParam(name="userName", required = false) String userName,
        // @RequestParam int userAge의 name을 지정하지 않으면 알아서 찾음/ 받는 타입인 userAge의 값을 지정해줘야함
        @RequestParam() int userAge
    ){ 
        // return을 통해서 body에 표시해줌
        return "사용자 아이디" + userId + "/사용자 이름:" + userName + "/사용자 나이:" + userAge;
    }

    // @PathVariable() : 
    // 모든 HTTP 메서드에서 URL의 특정 패턴에 따라서 데이터를 추출하는 방식

    // HTTP DELETE localhost:4000/request-data/path-variable
    @DeleteMapping("/path-variable/{age}") // -> /{} : 패턴을 입력해준거임
    // http://localhost:4000/request-data/path-variable/10
    public String deletePathVariable(
        // int로 받으면 사용자가 0을 입력했는지 입력을 안해서 0인지 알 수 없기 때문에 참조형 변수인 Integer를 사용
        @PathVariable("age") Integer age 
    ){
        return "사용자 나이:" + age;
    }

    // HTTP PATCH localhost:4000/request-data/patch/gildong/update
    // 게시물 1보기 / 삭제/ 수정 - [일반 유저/ 소유 팀/ 작성자]
    // GET board/{boardNumber}/normal
    // GET board/{boardNumber}/team
    // GET board/{boardNumber}/writer
    @PatchMapping("/patch/{userName}/update")
    public String patchUpdate (
        @PathVariable("userName") String userName
    ) {
        return "사용자 이름:" + userName;
    }
    //! *****주의 동일한 패턴인지 꼭 확인해야함
    // URL 패턴으로 데이터를 받아오는 방식을 썼을 때 겹치는 패턴이 존재하는지 잘 확인해야함
    @GetMapping("/{value}/get")
    public String getPathVariable1(
        @PathVariable("value") String value
    ){
        return "getPathVariable1";
    }

    @GetMapping("/get/{value}")
    public String getPathVariable2(
        @PathVariable("value") String value
    ){
        return "getPathVariable2";
    }
}
