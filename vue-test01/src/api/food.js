import service from "../main";

export function getFoodList() {
  return service({
    url: "/food",
    method: "get"
  });
}

export function updFoodById(id,data){
  return service({
    url: "/food/"+id,
    method: "put",
    data:data
  });
}

export function delFoodById(fid){
  return service({
    url: "/food/"+fid,
    method: "delete"
  });
}

export function addFood(data){
  return service({
    url: "/food",
    method: "post",
    data:data
  });
}

export function getTypes(){
  return service({
    url: "/types",
    method: "get"
  });
}
