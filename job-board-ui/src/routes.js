import Listings from 'views/Listings'

var routes = [
  {
    path: '/listings',
    name: 'Listings',
    icon: 'nc-icon nc-tile-56',
    component: <Listings />,
    layout: '/admin'
  }
]
export default routes
