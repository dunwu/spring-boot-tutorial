package io.github.dunwu.springboot;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "用户管理")
@RequestMapping("/user")
@RestController
public class UserController {

    private UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @ApiOperation("创建用户")
    @PostMapping("/add")
    public ResponseDTO<User> add(@RequestBody @Valid User user) {
        User save = repository.save(user);
        return new ResponseDTO<>(true, ResponseDTO.CodeEn.SUCCESS, save);
    }

    @ApiOperation("根据ID查用户详情")
    @GetMapping("/find/{id}")
    public ResponseDTO<User> findById(@PathVariable Long id) {
        User user = repository.findById(id).get();
        return new ResponseDTO<>(true, ResponseDTO.CodeEn.SUCCESS, user);
    }

    @ApiOperation("根据name查用户详情")
    @GetMapping("/find")
    public ResponseDTO<User> findByName(@RequestParam("name") String name) {
        User user = repository.findByName(name).get();
        return new ResponseDTO<>(true, ResponseDTO.CodeEn.SUCCESS, user);
    }

    @ApiOperation("用户列表")
    @GetMapping("/list")
    public ResponseDTO<List<User>> list() {
        Iterable<User> iterable = repository.findAll();
        List<User> users = IterableUtils.toList(iterable);
        return new ResponseDTO<>(true, ResponseDTO.CodeEn.SUCCESS, users);
    }

    @ApiOperation("用户列表分页展示")
    @GetMapping("/listInPage")
    public ResponseDTO<Page<User>> listInPage(@ApiParam("查看第几页") @RequestParam int page,
        @ApiParam("每页多少条") @RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> userPage = repository.findAll(pageRequest);
        return new ResponseDTO<>(true, ResponseDTO.CodeEn.SUCCESS, userPage);
    }

    @ApiIgnore
    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseDTO<>(true, ResponseDTO.CodeEn.SUCCESS, null);
    }

}
