package com.wjl.virosa.modules.pins.controller;

import com.wjl.virosa.common.annotation.TimeLog;
import com.wjl.virosa.common.constant.consts.RespResult;
import com.wjl.virosa.common.constant.enums.RespStatus;
import com.wjl.virosa.modules.pins.model.entity.Pin;
import com.wjl.virosa.modules.pins.model.view.PinView;
import com.wjl.virosa.modules.pins.service.PinService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * pin controller
 *
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/6 20:14
 */
@Slf4j
@TimeLog
@RestController
@RequestMapping(path = "/pin")
public class PinController {

  @Resource
  private PinService pinService;

  /**
   * select all pins
   *
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.GET, path = "/all")
  public RespResult<?> selectAll() {
    return RespResult.success(pinService.selectAll());
  }

  /**
   * select all pins by authorId
   *
   * @param authorId authorId
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.GET, path = "/all/author")
  public RespResult<?> selectAllByAuthorId(@RequestParam(name = "authorId") Long authorId) {
    return RespResult.success(pinService.selectAllByAuthorId(authorId));
  }

  /**
   * select all pins by page
   *
   * @param pageable format => page=1&size=5&sort=id,asc
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.GET, path = "/page")
  public RespResult<?> selectAllByPage(
      @PageableDefault(sort = "updateTime", direction = Sort.Direction.DESC) Pageable pageable) {
    log.info("page={}&size={}&sort={}", pageable.getPageNumber(),
        pageable.getPageSize(), pageable.getSort());
    return RespResult.success(pinService.selectAllByPage(pageable));
  }

  /**
   * select all pins by page and by authorId
   *
   * @param authorId authorId
   * @param pageable format => page=1&size=5&sort=id,asc
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.GET, path = "/page/author")
  public RespResult<?> selectAllByPageAndAuthorId(
      @RequestParam(name = "authorId") Long authorId,
      @PageableDefault(sort = "updateTime", direction = Sort.Direction.DESC) Pageable pageable) {
    log.info("page={}&size={}&sort={}", pageable.getPageNumber(),
        pageable.getPageSize(), pageable.getSort());
    return RespResult.success(pinService.selectAllByAuthorIdAndPage(authorId, pageable));
  }

  /**
   * select pin by id
   *
   * @param id id
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.GET, path = "/single")
  public RespResult<?> selectById(@RequestParam(name = "id") Long id) {
    PinView pinView = pinService.selectById(id);
    if (!Objects.equals(pinView, null)) {
      return RespResult.success(pinView);
    }
    return RespResult.fail(RespStatus.NOT_EXIST);
  }

  /**
   * add a pin
   *
   * @param pin pin
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.POST, path = "/add")
  public RespResult<?> add(@RequestBody Pin pin) {
    if (!Objects.equals(pin, null)) {
      pinService.add(pin);
      return RespResult.success();
    }
    return RespResult.fail(RespStatus.OBJECT_NULL);
  }

  /**
   * update pin
   *
   * @param pin pin
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.PUT, path = "/update")
  public RespResult<?> update(@RequestBody Pin pin) {
    if (!Objects.equals(pin, null)) {
      boolean flag = pinService.update(pin);
      if (flag) {
        return RespResult.success();
      }
      return RespResult.fail(RespStatus.NOT_EXIST);
    }
    return RespResult.fail(RespStatus.OBJECT_NULL);
  }

  /**
   * delete pin by id
   *
   * @param id id
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.DELETE, path = "/delete")
  public RespResult<?> deleteById(@RequestParam(name = "id") Long id) {
    boolean flag = pinService.deleteById(id);
    if (flag) {
      return RespResult.success();
    }
    return RespResult.fail(RespStatus.NOT_EXIST);
  }

}
