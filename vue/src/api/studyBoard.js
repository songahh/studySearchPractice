import { localAxios } from "@/utils/http-commons.js";

const local = localAxios();

function listBoard(params, success, fail) {
  local.get("/api/v1/study/list", { params }).then(success).catch(fail);
}

export { listBoard };