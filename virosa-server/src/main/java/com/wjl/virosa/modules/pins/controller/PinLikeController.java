package com.wjl.virosa.modules.pins.controller;

import com.wjl.virosa.common.annotation.TimeLog;
import com.wjl.virosa.common.constant.consts.RespResult;
import com.wjl.virosa.common.constant.enums.RespStatus;
import com.wjl.virosa.modules.pins.model.entity.PinLike;
import com.wjl.virosa.modules.pins.model.entity.PinLikeId;
import com.wjl.virosa.modules.pins.model.param.PinLikeParam;
import com.wjl.virosa.modules.pins.service.PinLikeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * pin like controller
 *
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/8 12:40
 */
@Slf4j
@TimeLog
@RestController
@RequestMapping(path = "/pin/like")
public class PinLikeController {

  @Resource
  private PinLikeService pinLikeService;

  /**
   * select all pinLikes
   *
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.GET, path = "/all")
  public RespResult<?> selectAll() {
    return RespResult.success(pinLikeService.selectAll());
  }

  /**
   * select all pinLikes by userId
   *
   * @param userId userId
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.GET, path = "/user")
  public RespResult<?> selectAllByUserId(@RequestParam(name = "userId") Long userId) {
    return RespResult.success(pinLikeService.selectAllByUserId(userId));
  }

  /**
   * select all pinLikes by page
   *
   * @param pageable format => page=1&size=5&sort=id,asc
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.GET, path = "/page")
  public RespResult<?> selectAllByPage(
      @PageableDefault(sort = "type", direction = Sort.Direction.DESC) Pageable pageable) {
    log.info("page={}&size={}&sort={}", pageable.getPageNumber(),
        pageable.getPageSize(), pageable.getSort());
    return RespResult.success(pinLikeService.selectAllByPage(pageable));
  }

  /**
   * select all pinLikes by page
   *
   * @param userId   userId
   * @param pageable format => page=1&size=5&sort=id,asc
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.GET, path = "/page/user")
  public RespResult<?> selectAllByUserIdAndPage(
      @RequestParam(name = "userId") Long userId,
      @PageableDefault(sort = "type", direction = Sort.Direction.DESC) Pageable pageable) {
    log.info("page={}&size={}&sort={}", pageable.getPageNumber(),
        pageable.getPageSize(), pageable.getSort());
    return RespResult.success(pinLikeService.selectAllByUserIdAndPage(userId, pageable));
  }

  /**
   * select pinLike by id
   *
   * @param pinId  pinId
   * @param userId userId
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.GET, path = "/single")
  public RespResult<?> selectById(
      @RequestParam(name = "pinId") Long pinId, @RequestParam(name = "userId") Long userId) {
    PinLike pinLike = pinLikeService.selectById(new PinLikeId(pinId, userId));
    if (!Objects.equals(pinLike, null)) {
      return RespResult.success(pinLike);
    }
    return RespResult.fail(RespStatus.NOT_EXIST);
  }

  /**
   * add a pinLike
   *
   * @param param pinLikeParam
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.POST, path = "/add")
  public RespResult<?> add(@RequestBody PinLikeParam param) {
    PinLikeId pinLikeId = new PinLikeId(param.getPinId(), param.getUserId());
    PinLike pinLike = pinLikeService.selectById(pinLikeId);
    log.info("{}", pinLike);
    if (Objects.equals(pinLike, null)) {
      pinLikeService.add(new PinLike(pinLikeId, param.getType()));
      return RespResult.success();
    }
    return RespResult.fail(RespStatus.ALREADY_EXIST);
  }

  /**
   * update a pinLike
   * TODO: have not been tested
   *
   * @param param pinLikeParam
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.PUT, path = "/update")
  public RespResult<?> update(@RequestBody PinLikeParam param) {
    PinLikeId id = new PinLikeId(param.getPinId(), param.getUserId());
    PinLike pinLike = pinLikeService.selectById(id);
    if (!Objects.equals(pinLike, null)) {
      if (Objects.equals(pinLike.getType(), param.getType())) {
        return RespResult.success("don't need to update");
      } else {
        pinLike.setType(param.getType());
        pinLikeService.update(pinLike);
        return RespResult.success("update success");
      }
    } else {
      PinLike newPinLike = new PinLike();
      newPinLike.setId(id);
      newPinLike.setType(param.getType());
      pinLikeService.add(newPinLike);
      return RespResult.success("update success");
    }
  }

  /**
   * delete pinLike by id
   *
   * @param id pinLikeId
   * @return RespResult<?>
   */
  @RequestMapping(method = RequestMethod.DELETE, path = "/delete")
  public RespResult<?> deleteById(@RequestBody PinLikeId id) {
    boolean flag = pinLikeService.deleteById(id);
    if (flag) {
      return RespResult.success();
    }
    return RespResult.fail(RespStatus.NOT_EXIST);
  }

}
