package com.wjl.virosa.modules.pins.controller;

import com.wjl.virosa.common.annotation.TimeLog;
import com.wjl.virosa.common.constant.consts.RespResult;
import com.wjl.virosa.common.constant.enums.RespStatus;
import com.wjl.virosa.modules.pins.model.view.PinView;
import com.wjl.virosa.modules.pins.service.PinService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    return RespResult.success(pinService.selectAllByPageAndAuthorId(authorId, pageable));
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

}
