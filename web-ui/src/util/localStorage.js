// const ACCESS_TOKEN = 'AccessToken';
// const REFRESH_TOKEN = 'RefreshToken';
//
// /**
//  * 获取token
//  * @returns {*}
//  * @constructor
//  */
// export function getAccessToken() {
//     var accessToken = localStorage.getItem(ACCESS_TOKEN);
//     return accessToken
// }
//
// /**
//  * 获取刷新token
//  * @returns {*}
//  * @constructor
//  */
// export function getRefresToken() {
//     return localStorage.getItem(REFRESH_TOKEN)
// }
//
// /**
//  * 保存token
//  * @returns {*}
//  * @constructor
//  */
// export function setToken(token) {
//     localStorage.setItem(ACCESS_TOKEN, token.accessToken);
//     localStorage.setItem(REFRESH_TOKEN, token.refreshToken);
// }
//
// /**
//  * 删除token
//  * @returns {*}
//  * @constructor
//  */
// export function removeToken() {
//     localStorage.removeItem(ACCESS_TOKEN);
//     localStorage.removeItem(REFRESH_TOKEN);
// }
//
// /**
//  * 退出时，清理数据
//  */
// export function logOut() {
//     localStorage.clear();
// }