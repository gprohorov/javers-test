package dev.bo.javerstest.request;


/*
  @author   george
  @project   proj-test
  @class  ItemCreateRequest
  @version  1.0.0 
  @since 11.04.25 - 18.51
*/

public record ItemUpdateRequest(String id,String name, String code, String description) {
}
