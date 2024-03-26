import { getAllListings } from 'helper/APIConnector'
import React from 'react'

import {
  Card,
  CardHeader,
  CardBody,
  CardTitle,
  Table,
  Row,
  Col,
  Modal,
  ModalHeader,
  ModalBody,
  ModalFooter,
  FormGroup,
  Input,
  Button
} from 'reactstrap'

function Listings () {

  const [listings, setListings] = React.useState([])
  const [selectedPosition, setSelectedPosition] = React.useState([])
  const [positionModal, setPositionModal] = React.useState(false)
  const [description, setDescription] = React.useState(false)

  React.useEffect(() => {
    getListings()
  }, [])

  const getListings = () => {
    getAllListings().then(res => {
      if (res) {
        setListings(res)
      }
    })
  }

  const openJobDetail = position => {
    setPositionModal(!positionModal)
    setSelectedPosition(position)
    formatDescription(position)
  }

  const formatDescription = position => {
    let des =
      position && position.description ? position.description.join('') : ''
    setDescription(des)
  }

  return (
    <>
      <div className='content'>
        <Row>
          <Col md='12'>
            <Card>
              <CardHeader>
                <CardTitle className='text-center' tag='h3'>Job Listings</CardTitle>
              </CardHeader>
              <CardBody>
                <Modal
                  size='xl'
                  className='mt-12'
                  isOpen={positionModal}
                  toggle={openJobDetail}
                >
                  <ModalHeader toggle={openJobDetail} charCode='x'>
                    {' '}
                    Job Detail
                  </ModalHeader>
                  <ModalBody>
                    <Row>
                      <Col className='pr-1' md='12'>
                        <FormGroup>
                          <label>Position</label>
                          <Input
                            read-only
                            placeholder='Company'
                            type='text'
                            value={selectedPosition.name}
                          />
                        </FormGroup>
                      </Col>
                      <Col className='pr-1' md='12'>
                        <FormGroup>
                          <label>Job Description</label>
                          <div
                            style={{
                              width: '100%',
                              // height: '300px',
                              border: '1px solid #ccc',
                              padding: '10px',
                              overflowY: 'auto'
                            }}
                            dangerouslySetInnerHTML={{
                              __html: description
                            }}
                          />
                        </FormGroup>
                      </Col>
                      <Col className='pr-1' md='6'>
                        <FormGroup>
                          <label>Office</label>
                          <Input
                            read-only
                            placeholder='Company'
                            type='text'
                            value={selectedPosition.office}
                          />
                        </FormGroup>
                      </Col>
                      <Col className='pr-1' md='6'>
                        <FormGroup>
                          <label>Department</label>
                          <Input
                            read-only
                            placeholder='Company'
                            type='text'
                            value={selectedPosition.department}
                          />
                        </FormGroup>
                      </Col>

                      <Col className='pr-1' md='6'>
                        <FormGroup>
                          <label>Schedule</label>
                          <Input
                            read-only
                            placeholder='Company'
                            type='text'
                            value={selectedPosition.schedule}
                          />
                        </FormGroup>
                      </Col>
                      <Col className='pr-1' md='6'>
                        <FormGroup>
                          <label>Employment Type</label>
                          <Input
                            read-only
                            placeholder='Company'
                            type='text'
                            value={selectedPosition.employmentType}
                          />
                        </FormGroup>

                      </Col>
                    </Row>
                    <Button className="float-right" color="primary">Apply</Button>
                  </ModalBody>
                  <ModalFooter></ModalFooter>
                </Modal>
                <Table striped hover responsive>
                  <thead className='text-primary '>
                    <tr>
                      <th>Position Name</th>
                      <th>Company</th>
                      <th>Office</th>
                      <th>Department</th>
                      <th>Schedule</th>
                      <th>Employment Type</th>
                      <th>Seniority</th>
                      <th>Category</th>
                    </tr>
                  </thead>
                  <tbody>
                    {listings &&
                      listings.map((listing, index) => {
                        return (
                          <tr
                            onClick={() => {
                              openJobDetail(listing)
                            }}
                          >
                            <td> {listing.name}</td>
                            <td> {listing.company} </td>
                            <td> {listing.office} </td>
                            <td> {listing.department} </td>
                            <td> {listing.schedule} </td>
                            <td> {listing.employmentType} </td>
                            <td> {listing.seniority} </td>
                            <td> {listing.occupationCategory} </td>
                          </tr>
                        )
                      })}
                  </tbody>
                </Table>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </div>
    </>
  )
}

export default Listings
