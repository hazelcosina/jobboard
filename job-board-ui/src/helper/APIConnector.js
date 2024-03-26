import { API_BASE_URL } from './Endpoints'


const request = options => {
  const headers = new Headers({
    'Content-Type': 'application/json'
  })

  const defaults = { headers: headers }
  options = Object.assign({}, defaults, options)
   
  return fetch(options.url, options).then(response =>
    response.json().then(json => {
      if (!response.ok) {
        return Promise.reject(json)
      }
      return json;
    })
  )
}

export function getAllListings () {
  return request({
    url: API_BASE_URL + '/positions',
    method: 'GET'
  })
}


