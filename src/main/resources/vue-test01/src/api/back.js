import service from "../main";

export function getBackList() {
  return service({
    url: "/back",
    method: "get"
  });
}
export function updBackById(id,data){
  return service({
    url: "/back/"+id,
    method: "put",
    data:data
  });
}

export function delBackById(id){
  return service({
    url: "/back/"+id,
    method: "delete"
  });
}

export function addBack(data){
  return service({
    url: "/back",
    method: "post",
    data:data
  });
}

export function getManYiDu() {
  return service({
    url: "/satisfaction",
    method: "get"
  });
}
